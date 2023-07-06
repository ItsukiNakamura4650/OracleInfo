package sqlmap;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;

public class MybatisManager {
	//DaoとXMLファイルの接続
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		//XMLで管理するsplクエリをリターンする。
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		//どこにSQLファイル用のXMLファイルがあるかを指定し、リソースを配列に格納
		Resource[] res = 
				new PathMatchingResourcePatternResolver()
				.getResources("classpath:sqlmap/*.xml");
		bean.setMapperLocations(res);
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}


}
