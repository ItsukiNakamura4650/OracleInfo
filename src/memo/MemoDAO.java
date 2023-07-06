package memo;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MemoDAO {
	SqlSession sqlSession;

	public Map<String, String> list(){
//		selectList()メソッドの第1引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		return sqlSession.selectList("product.list","");
	}
}
