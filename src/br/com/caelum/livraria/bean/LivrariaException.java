package br.com.caelum.livraria.bean;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = false)
public class LivrariaException extends RuntimeException {

}
