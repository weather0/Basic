package co.micol.study.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.study.comm.DataSource;
import co.micol.study.student.service.StudentMapper;
import co.micol.study.student.service.StudentService;
import co.micol.study.student.vo.StudentVO;

public class StudentServiceImpl implements StudentService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); //true가 없으면 auto commit이 안 됨
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);

	@Override
	public List<StudentVO> studentSelectList() {
		return map.studentSelectList();
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		return map.studentSelect(vo);
	}

	@Override
	public int studentInsert(StudentVO vo) {
		// TODO Auto-generated method stub
		return map.studentInsert(vo);
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		// TODO Auto-generated method stub
		return map.studentUpdate(vo);
	}

	@Override
	public int studentDelete(StudentVO vo) {
		// TODO Auto-generated method stub
		return map.studentDelete(vo);
	}

}
