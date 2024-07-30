package com.kh.semi;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.kh.spring06.dto.BookDto;
import com.kh.spring06.dto.EmpDto;
import com.kh.spring06.mapper.BookMapper;
import com.kh.spring06.mapper.StatusMapper;
import com.kh.spring06.vo.PageVo;
import com.kh.spring06.vo.StatusVo;

@Repository
public class BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private StatusMapper statusMapper;
	
	public void insert(BookDto dto) {
		
		String sql ="insert into book ("
				+ "book_id, "
				+ "book_title,"
				+ "book_author, "
				+ "book_publication_date,"
				+ " book_price ,"
				+ " book_publisher, "
				+ "book_page_count,"
				+ " book_genre)"
				+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?) ";
		
		
		
		Object[] data = {dto.getBookTitle(),dto.getBookAuthor()
				,dto.getBookPublicationDate(),dto.getBookPrice()
				,dto.getBookPublisher(),dto.getBookPageCount()
				,dto.getBookGenre()};
				
		jdbcTemplate.update(sql, data);


		
		
		
	}
	//조회+검색
		public List<BookDto> selectList() {
			String sql = "select * from book order by book_id asc";
			return jdbcTemplate.query(sql,bookMapper );
		}
		public List<BookDto> selectList(String column, String keyword) {
			String sql = "select * from book "
							+ "where instr(#1, ?) > 0 "
							+ "order by #1 asc, book_id asc";
			sql = sql.replace("#1", column);
			Object[] data = {keyword};
			return jdbcTemplate.query(sql, bookMapper, data);
		}

		public BookDto selectOne(int bookId) {
			String sql = "select * from book where book_id = ?";
			Object[] data = {bookId};
			List<BookDto> list = jdbcTemplate.query(sql,bookMapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
		
		
	   public boolean update(BookDto dto) {
			
			 String sql = "update book "
				        + "set book_title = ? , book_author= ? , book_publication_date = ? , "
						+ "book_price=? , book_publisher= ? ,  "
						+ " book_page_count = ? , book_genre = ?  "
						+ "where book_id = ? ";
			 Object[] data = {dto.getBookTitle(),dto.getBookAuthor(),
					 dto.getBookPublicationDate(),dto.getBookPrice(),
					 dto.getBookPublisher(),dto.getBookPageCount(),
					 dto.getBookGenre(),dto.getBookId()};
			 
			 
			 
			 return jdbcTemplate.update(sql,data) > 0;
	   }
	   public boolean delete(int BookId) {
			
			String sql =  "delete from book " +
                  "where book_id = ?";
			 Object[] data = {BookId};
	    	 return jdbcTemplate.update(sql,data) > 0;
	   }
	   public List<StatusVo> statusByBookGenre(){
	    	String sql ="select book_genre title ,"
	    			+ " count(*) cnt  from "
	    			+ "book group by book_genre";
	    	
	    	return jdbcTemplate.query(sql,statusMapper );
	    }
	   public List<BookDto> selectListByPaging(PageVo pageVo) { 
			if(pageVo.isSearch()) {//검색
				String sql = "select * from ("
									+ "select rownum rn, TMP.* from ("
										+ "select * from book where instr(#1, ?) > 0 "
										+ "order by #1 asc, book_id asc"
									+ ")TMP"
								+ ") where rn between ? and ?";
				sql = sql.replace("#1", pageVo.getColumn());
				Object[] data = {
					pageVo.getKeyword(), 
					pageVo.getBeginRow(), pageVo.getEndRow()
				};
				return jdbcTemplate.query(sql, bookMapper, data);
			}
			else {//목록
				String sql = "select * from ("
									+ "select rownum rn, TMP.* from ("
										+ "select * from book order by book_id asc"
									+ ")TMP"
								+ ") where rn between ? and ?";
				Object[] data = {pageVo.getBeginRow(), pageVo.getEndRow()};
				return jdbcTemplate.query(sql, bookMapper, data);
			}
		}
		public int countByPaging(PageVo pageVo) {
			if(pageVo.isSearch()) {//검색
				String sql = "select count(*) from book where instr(#1, ?) > 0";
				sql = sql.replace("#1", pageVo.getColumn());
				Object[] data = {pageVo.getKeyword()};
				return jdbcTemplate.queryForObject(sql, int.class, data);
			}
			else {//목록
				String sql = "select count(*) from book";
				return jdbcTemplate.queryForObject(sql, int.class);
			}
			}
			public int sequence() {
				String sql = "select book_seq.nextval from dual";
				return jdbcTemplate.queryForObject(sql, int.class);
			}
		public void insertWithSequence(BookDto bookDto) {
			
			String sql ="insert into book ("
					+ "book_id, "
					+ "book_title,"
					+ "book_author, "
					+ "book_publication_date,"
					+ " book_price ,"
					+ " book_publisher, "
					+ "book_page_count,"
					+ " book_genre) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?) ";
			
			
			
			Object[] data = {
					bookDto.getBookId()
					,bookDto.getBookTitle()
					,bookDto.getBookAuthor()
					,bookDto.getBookPublicationDate()
					,bookDto.getBookPrice()
					,bookDto.getBookPublisher()
					,bookDto.getBookPageCount()
					,bookDto.getBookGenre()
					
			
			};     

			 jdbcTemplate.update(sql,data);
		}

		public void connect(int bookId, int attachmentNo) {
			String sql="insert into book_image ( book,attachment ) "
					+ "values(?,?)";
			Object[] data = {
					bookId,attachmentNo
					
			};
			jdbcTemplate.update(sql,data);
		}
		public int  findImage(int bookId) {
			String sql = "select attachment from book_image where book=?";
			Object[] data = {bookId};
			return jdbcTemplate.queryForObject(sql ,int.class,data);
		

		

		}
		public List<Integer> findImages(int bookId){
			String sql ="select attachment from book_image where book=?";
			Object[] data = {bookId};
			return jdbcTemplate.queryForList(sql,Integer.class,data);
		}
		
	}

