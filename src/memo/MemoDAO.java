package memo;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MemoDAO {
	SqlSession sqlSession;

	public Map<String, String> list(){
//		selectList()メソッドの第1引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		return sqlSession.selectMap("product.select","");
	}

//	一件登録
	public void insert(Map<String, String> map) {
		sqlSession.insert("product.insert", map);
	}

	public Map<String, String> writerfilter(String writer){
//		selectList()メソッドの第1引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		return sqlSession.selectMap("product.writerfilter", "%" + writer + "%");
	}

	public Map<String, String> memofilter(String memo){
//		selectList()メソッドの第1引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		return sqlSession.selectMap("product.memofilter", "%" + memo + "%");
	}

	public Map<String, String> filter(String memo ,String writer){
//		selectList()メソッドの第1引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		return sqlSession.selectMap("product.writerlist", "%" + memo + "%");
	}

//	詳細取得
	public Map<String, String> detail(String idx) {
		return sqlSession.selectOne("product.detail", idx);
	}

//	1件更新
	public void update(Map<String, String> map) {
		sqlSession.update("product.update", map);
	}

//	一件削除
	public void delete(String idx) {
		sqlSession.delete("product.delete", idx);
	}

}
