package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {
	
	public static boolean esDiaHabil(LocalDate fecha) {
		int day = fecha.getDayOfWeek().getValue();
		
		return day >= 1 && day <= 5;
	}
	
	public static boolean esBisiesto(int anio) {
		return (anio % 4 == 0) && !((anio % 100 == 0) && (anio % 400 != 0));
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		return String.format("%02d/%02d/%d", fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear());
	}
	
	// Método redundante
	public static String traerHoraCorta(LocalTime hora) {
		return String.format("%02d:%02d", hora.getHour(), hora.getMinute());
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String[] dias = {
			"Lunes",
			"Martes",
			"Miércoles",
			"Jueves",
			"Viernes",
			"Sábado",
			"Domingo"
		};
		
		return dias[fecha.getDayOfWeek().getValue() - 1];
	}
	
	public static String traerMesEnLetras(LocalDate fecha) {
		String[] meses = {
			"Enero",
			"Febrero",
			"Marzo",
			"Abril",
			"Mayo",
			"Junio",
			"Julio",
			"Agosto",
			"Septiembre",
			"Octubre",
			"Noviembre",
			"Diciembre"
		};
		
		return meses[fecha.getMonthValue() - 1];
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		return Funciones.traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + Funciones.traerMesEnLetras(fecha) + " del " + fecha.getYear();
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		return LocalDate.of(anio, mes, 1).lengthOfMonth();
	}
	
	public static boolean fechaEstaEntre(LocalDate fechaEvaluada, LocalDate fechaInicio, LocalDate fechaFin) {
		return fechaEvaluada.isAfter(fechaInicio) && fechaEvaluada.isBefore(fechaFin);
	}
	
	public static boolean fechaEstaEntreInclusive(LocalDate fechaEvaluada, LocalDate fechaInicio, LocalDate fechaFin) {
		return !(fechaEvaluada.isBefore(fechaInicio)) && !(fechaEvaluada.isAfter(fechaFin));
	}
	
}
