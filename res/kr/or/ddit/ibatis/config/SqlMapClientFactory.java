package kr.or.ddit.ibatis.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	
	//mapper로 접근하기위한 객체  client
	private static SqlMapClient client;

	static {

		try{
			// 1. iBatis의 환경 설정 파일(sqlMapConfig.xml)을 읽어와 실행 시킨다.
			// 1-1. 문자 인코딩 케릭터셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);

			// 1-2. xml문서 읽어오기
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");

			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 수행할
			//		SqlMapClient 객체를 생성한다.
			client = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();  // Reader객체 닫기
		}catch(Exception ex){ 

		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return client;
	}

}
