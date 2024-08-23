package ec.com.tecnointel.soem.general.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ec.com.tecnointel.soem.inventario.modelo.ProdGrupNive;

// Ejemplo para crear validadores propios

// Para utilizar se coloca @ValidadorTestInt en la clase ProdGrupNive
public class ValidadorTest implements ConstraintValidator<ValidadorTestInt, ProdGrupNive>{

	@Override
	public void initialize(ValidadorTestInt constraintAnnotation) {
	}

	@Override
	public boolean isValid(ProdGrupNive prodGrupNive, ConstraintValidatorContext context) {
		return prodGrupNive.getNivel() < 100;
	}

}
