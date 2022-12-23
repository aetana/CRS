package miu.edu.CourseRegistration1;

import miu.edu.CourseRegistration1.entity.*;
import miu.edu.CourseRegistration1.repository.AdminRepo;
import miu.edu.CourseRegistration1.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class CourseRegistration1Application implements CommandLineRunner {

	@Autowired
	private AddressServiceImpl addressService;
	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private CourseOfferingServiceImpl courseOfferingService;

	@Autowired
	private AcademicBlockServiceImpl academicBlockService;
	@Autowired
	private RegistrationGroupServiceImpl registrationGroupService;

	@Autowired
	private RegistrationEventServiceImpl registrationEventService;

	@Autowired
	private FacultyServiceImpl facultyService;

	@Autowired
	private AdminServiceImpl adminService;
	public static void main(String[] args) {
		SpringApplication.run(CourseRegistration1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User userAdmin = new User("admin", "admin", "admin");
//		User userAmanuel = new User( "amanuel", "amanuel", "student");
//		User userHanna = new User( "hanna", "hana", "student");
//		User userPayman = new User("payman", "payman", "faculty");
//
//		userService.addAll(List.of(user1,user2,user3,user4));

		Address add1 = new Address("1000 N 4th St","Fairfield","52557", "IOWA","USA" );
		Address add2 = new Address("2000 E 5th St", "CALIFORNIA", "52556","LA","USA");

		addressService.createAddsress(add1);
		addressService.createAddsress(add2);

		Student bifomo = new Student("Bifomo","Abdallah","bifomo.abdallah@miu.edu" ,615162L,"bifomo", "bifomo",  add1 );
		Student hanna = new Student("Hanna","Beyene" ,"hanna.beyene@miu.edu" , 615164L, "hanna", "hanna", add1 );
		Student amanuel = new Student("Amanuel","Etana","amanuel.abeben@gmail.com.edu", 615166L,"amanuel", "amanuel",  add1 );
		Student rufael = new Student("Rufael ","Yohannes","rg.yohannes@miu.edu",615163L, "rufael","rufael" , add2 );
		Student donald = new Student("Donald","Nyagwande","donald.nyagwande@miu.edu" , 615165L,"donald","donald", add2 );

		Faculty payman = new Faculty("Payman", "Salek","psalek@miu.edu","payman", "payman");
		facultyService.add(payman);

		Admin admin = new Admin("Root","Admin","admin@gmail.com", "admin", "admin");
		adminService.add(admin);

		Course ea = new Course("Enterprise Architecture","This course focuses Enterprise Architecture","CS544");
		Course waa = new Course("Web Application","This course focuses Web Application","CS545");
		Course mwa = new Course("Modern Web Applications","This course focuses Modern Web Applications","CS572");
		Course mad = new Course("Mobile Application Development","This course focuses Mobile Application Development","CS571");


		//December Block
		CourseOffering decEA = new CourseOffering("CS544-2022-12A-12D-PS",25,0,25,"PS");
		CourseOffering decWAA = new CourseOffering("CS545-2022-12A-12D-AO",25,0,25,"AO");
		CourseOffering decMWA = new CourseOffering("CS572-2022-12A-12D-NN",25,0,25,"NN");
		CourseOffering decMAD = new CourseOffering("CS571-2022-12A-12D-ME",25,0,25,"ME");


		//November Block
		CourseOffering novEA = new CourseOffering("CS544-2022-11A-11D-PS",25,0,25,"PS");
		CourseOffering novMAD = new CourseOffering("CS571-2022-11A-11D-ME",25,0,25,"ME");
		CourseOffering novWAA = new CourseOffering("CS545-2022-11A-121D-AO",25,0,25,"AO");
		CourseOffering novMWA = new CourseOffering("CS572-2022-11A-11D-NN",25,0,25,"NN");

		//January Block
		CourseOffering janEA = new CourseOffering("CS544-2023-1A-1D-PS",25,0,25,"PS");
		CourseOffering janMAD = new CourseOffering("CS571-2023-1A-1D-ME",25,0,25,"ME");
		CourseOffering janWAA = new CourseOffering("CS545-2023-1A-1D-AO",25,0,25,"AO");

		//February Block
		CourseOffering febEA = new CourseOffering("CS544-2023-2A-2D-PS",25,0,25,"PS");
		CourseOffering febMAD = new CourseOffering("CS571-2023-2A-2D-ME",25,0,25,"ME");
		CourseOffering febWAA = new CourseOffering("CS545-2023-2A-2D-AO",25,0,25,"AO");

		//Set course for Course Offering
		decEA.setCourse(ea);
		decWAA.setCourse(waa);
		decMWA.setCourse(mwa);
		decMAD.setCourse(mad);

		novEA.setCourse(ea);
		novMAD.setCourse(mad);
		novWAA.setCourse(waa);
		novMWA.setCourse(mwa);

		janEA.setCourse(ea);
		janMAD.setCourse(mad);
		janWAA.setCourse(waa);

		febEA.setCourse(ea);
		febMAD.setCourse(mad);
		febWAA.setCourse(waa);


		//courseOfferingService.saveAll(List.of(novEA,novMAD));
		//courseOfferingService.saveAll(List.of(janEA,janMAD));
		//courseOfferingService.saveAll(List.of(febEA,febMAD));

		AcademicBlock novBlock = new AcademicBlock("2022-12A-12D","December 2022","Spring", LocalDate.of(2022,12,1),LocalDate.of(2022,12,30));
		AcademicBlock decBlock = new AcademicBlock("2022-11A-11D","November 2022","Spring", LocalDate.of(2022,11,1),LocalDate.of(2022,11,30));
		AcademicBlock janBlock = new AcademicBlock("2023-12A-12D","December 2023","Winter", LocalDate.of(2023,1,1),LocalDate.of(2022,12,30));
		AcademicBlock febBlock = new AcademicBlock("2023-11A-11D","November 2023","Winter", LocalDate.of(2023,2,1),LocalDate.of(2022,11,27));

		novBlock.setCourseOffering(List.of(novEA,novMAD,novWAA,novMWA));
		decBlock.setCourseOffering(List.of(decEA,decWAA,decMWA,decMAD));
		janBlock.setCourseOffering(List.of(janEA,janMAD,novWAA));
		febBlock.setCourseOffering(List.of(febEA,febMAD,novWAA));


		RegistrationGroup rGroup1 = new RegistrationGroup();
		RegistrationGroup rGroup2 = new RegistrationGroup();
		RegistrationGroup rGroup3 = new RegistrationGroup();


		// Assign students to Registration group
		rGroup1.setStudents(List.of(donald,rufael,bifomo,hanna,amanuel));
		rGroup2.setStudents(List.of(donald,rufael,bifomo));
		rGroup3.setStudents(List.of(hanna,amanuel));

		rGroup1.setAcademicBlocks(List.of(novBlock,decBlock));
		rGroup2.setAcademicBlocks(List.of(janBlock,febBlock));
		rGroup3.setAcademicBlocks(List.of(febBlock));

		RegistrationEvent rEvent1 = new RegistrationEvent(LocalDate.of(2022,10,1),LocalDate.of(2022,10,7));
		RegistrationEvent rEvent2 = new RegistrationEvent(LocalDate.of(2022,12,20),LocalDate.of(2022,12,27));
		RegistrationEvent rEvent3 = new RegistrationEvent(LocalDate.of(2023,10,1),LocalDate.of(2023,11,7));

		rEvent1.setRegistrationGroups(List.of(rGroup1));
		rEvent2.setRegistrationGroups(List.of(rGroup2));
		rEvent3.setRegistrationGroups(List.of(rGroup3));


		registrationGroupService.saveAll(List.of(rGroup1,rGroup2,rGroup3));
		studentService.addAll(List.of(hanna,amanuel,rufael,bifomo,donald));

		academicBlockService.saveAll(List.of(novBlock,decBlock,janBlock,febBlock));

		registrationEventService.addAll(List.of(rEvent1,rEvent2,rEvent3));

		courseOfferingService.saveAll(List.of(decEA,decWAA,decMWA,decMAD,novEA,novMAD,janEA,janMAD,febEA,febMAD));
		//registrationGroupService.createRegistrationGroup(rGroup2);

//		registrationEventService.createRegistrationEvent(rEvent1);
//		registrationEventService.createRegistrationEvent(rEvent2);





	}


}
