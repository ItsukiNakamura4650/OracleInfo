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
	public void insert(Map<String, String> productDTO) {
		sqlSession.insert("product.insert", productDTO);
	}

//	詳細取得
	public Map<String, String> detail(String idx) {
		return sqlSession.selectOne("product.detail", idx);
	}

//	1件更新
	public void update(Map<String, String> productDTO) {
		sqlSession.update("product.update", productDTO);
	}

//	一件削除
	public void delete(int idx) {
		sqlSession.delete("product.delete", idx);
	}

//	1件取得
	public String filename(int idx) {
		return sqlSession.selectOne("product.filename", idx);
	}
}
