package com.challenge.desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;


public class CalculadorDeClasses implements Calculavel {
	
	public Field[] fields(Object object){
		 return object.getClass().getDeclaredFields();
		}

	@Override
	public BigDecimal somar(Object object) {
		return calcular(object, Somar.class);
		// TODO Auto-generated method stub
	
	}

	@Override
	public BigDecimal subtrair(Object object) {
		// TODO Auto-generated method stub
		return calcular(object, Subtrair.class);
	}

	@Override
	public BigDecimal totalizar(Object object) {
		
		
		// TODO Auto-generated method stub
		return somar(object).subtract(subtrair(object));
	}

	
	public BigDecimal validar(Object object, Field field) {
		try {
			field.setAccessible(true);
			return (BigDecimal) field.get(object);
			
		}catch(IllegalAccessException e) {
			return BigDecimal.ZERO;
		}		
	}
	
	private BigDecimal calcular(Object object, Class<? extends Annotation> annotation) {
		
		return Arrays.asList(fields(object)).stream()
			.filter(field -> field.isAnnotationPresent(annotation)).map(field -> validar(object, field)).reduce(BigDecimal.ZERO, BigDecimal::add);
			      
				
	}
	
	

}
