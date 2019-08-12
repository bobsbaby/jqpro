package kr.or.ddit.prod.controller;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;

public class Test {

	public static void main(String[] args) {
		IProdService service = ProdServiceImpl.getInstance();
		System.out.println(service.selectProdNames("P101").size());
	}

}
