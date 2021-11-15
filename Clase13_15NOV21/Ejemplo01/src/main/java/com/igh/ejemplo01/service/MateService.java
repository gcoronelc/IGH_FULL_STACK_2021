package com.igh.ejemplo01.service;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class MateService {

	
	public int mcd(int n1, int n2){
		while(n1!=n2){
			if(n1>n2){
				n1 -= n2;
			} else {
				n2-=n1;
			}
		}
		return n1;
	}
	
	public int mcm(int n1, int n2){
		int valor;
		valor = n1*n2 / mcd(n1,n2);
		return valor;
	}
}
