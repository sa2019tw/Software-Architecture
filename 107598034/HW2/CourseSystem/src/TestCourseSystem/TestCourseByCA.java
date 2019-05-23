package TestCourseSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Adapter.Presenter.AddCoursePresenter;
import Adapter.Presenter.DeleteCoursePresenter;
import Adapter.Presenter.EditCoursePresenter;
import Adapter.Repository.InMemoryCourseRepository;
import CourseUseCase.CourseRepository;
import CourseUseCase.AddCourseUseCase.AddCourseInput;
import CourseUseCase.AddCourseUseCase.AddCourseOutput;
import CourseUseCase.AddCourseUseCase.AddCourseUseCase;
import CourseUseCase.AddCourseUseCase.AddCourseUseCaseImpl;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseInput;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseOutput;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseUseCase;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseUseCaseImpl;
import CourseUseCase.EditCourseUseCase.EditCourseInput;
import CourseUseCase.EditCourseUseCase.EditCourseOutput;
import CourseUseCase.EditCourseUseCase.EditCourseUseCase;
import CourseUseCase.EditCourseUseCase.EditCourseUseCaseImpl;

public class TestCourseByCA {
	CourseRepository inMemeoryRepository = new InMemoryCourseRepository();
	
	@Before
	public void setUp() throws Exception {
		AddCourseUseCase addNewCourseUseCase1 = new AddCourseUseCaseImpl(inMemeoryRepository);
		AddCourseUseCase addNewCourseUseCase2 = new AddCourseUseCaseImpl(inMemeoryRepository);
		
		AddCourseInput input1 = (AddCourseInput)addNewCourseUseCase1;
		input1.setCourseName("POSD");
		
		AddCourseOutput output1 =  new AddCoursePresenter();
		
		AddCourseInput input2 = (AddCourseInput)addNewCourseUseCase2;
		input2.setCourseName("IR");
		
		AddCourseOutput output2 =  new AddCoursePresenter();
		addNewCourseUseCase1.execute(input1, output1);
		addNewCourseUseCase2.execute(input2, output2);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void Add_New_Course_By_CourseName() {
		
		assertEquals(2, inMemeoryRepository.getAllCourse().size());
	}
	
	@Test
	public void Edit_Course_By_CourseName() {
		AddCourseUseCase addNewCourseUseCase = new AddCourseUseCaseImpl(inMemeoryRepository);
		AddCourseInput addInput = (AddCourseInput)addNewCourseUseCase;
		addInput.setCourseName("ST");
		AddCourseOutput addOutput =  new AddCoursePresenter();
		addNewCourseUseCase.execute(addInput, addOutput);
		
		EditCourseUseCase editCourseUseCase = new EditCourseUseCaseImpl(inMemeoryRepository);
		
		EditCourseInput input = (EditCourseInput)editCourseUseCase;
		input.setCourseId(addOutput.getCourseId());
		input.setCourseName("Clean Architecture");
		
		EditCourseOutput output =  new EditCoursePresenter();
		editCourseUseCase.execute(input, output);
		
		assertEquals("Clean Architecture", inMemeoryRepository.getAllCourse().get(output.getCourseId()).getCourseName());
	}
	
	@Test
	public void Delete_Course_By_CourseName() {
		AddCourseUseCase addNewCourseUseCase = new AddCourseUseCaseImpl(inMemeoryRepository);
		AddCourseInput input = (AddCourseInput)addNewCourseUseCase;
		input.setCourseName("ST");
		AddCourseOutput output =  new AddCoursePresenter();
		addNewCourseUseCase.execute(input, output);
		assertEquals(3, inMemeoryRepository.getAllCourse().size());
		
		DeleteCourseUseCase deleteCourseUseCase = new DeleteCourseUseCaseImpl(inMemeoryRepository);
		
		DeleteCourseInput deleteInput = (DeleteCourseInput) deleteCourseUseCase;
		deleteInput.setCourseId(output.getCourseId());
		
		DeleteCourseOutput deleteOutput = new DeleteCoursePresenter();
		
		deleteCourseUseCase.execute(deleteInput, deleteOutput);
		
		assertEquals(2, inMemeoryRepository.getAllCourse().size());
	}
}
