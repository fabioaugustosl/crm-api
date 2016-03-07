package br.com.virtz.cfc.servlet.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import br.com.virtz.cfc.entidades.FormaPagamento;

@Provider
public class FormaPagamentoParamConverter implements ParamConverterProvider {

	private ParamConverter<FormaPagamento> carConverter = new ParamConverter<FormaPagamento>() {
		 
		@Override
		public FormaPagamento fromString(String arg0) {
			FormaPagamento car = new FormaPagamento();
			car.setDescricao(arg0);
			return car;
		}
 
		@Override
		public String toString(br.com.virtz.cfc.entidades.FormaPagamento arg0) {
			return arg0.getDescricao();
		}
 
	};

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType,
			Type genericType, Annotation[] annotations) {
		if(rawType.equals(FormaPagamento.class)) {
			return (ParamConverter<T>) carConverter;
		}
		return null;
	}
	
	
	
}
