package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object loga(InvocationContext context) throws Exception {

		long millis = System.currentTimeMillis();

		Object retorno = context.proceed();

		System.out.println("[Aviso] Tempo gasto: " + (System.currentTimeMillis() - millis) + "ms");
		
		System.out.println("[Aviso] Método executado: " + context.getTarget().getClass().getSimpleName() + "/" + context.getMethod().getName());

		return retorno;
	}

}
