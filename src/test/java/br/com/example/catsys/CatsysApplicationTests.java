package br.com.example.catsys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CatsysApplicationTests {

	@Test
	void contextLoads() {
	}
	
	/*
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private ModelMapper mapper;
		
	@Test
	void shouldReturnApplicationMapped() {
		var dto = ApplicationDTO.builder()
			.name("Catalog of Systems")
			.abbreviationCode("catsys")
			.description("Catalog of systems test application")
			.sourceCodeLocationUrl("https://github.com/kassiogo/system-catalog")
			.build();

		var application = this.mapper.map(dto, Application.class);
		assertNull(application.getId());
		assertEquals("Catalog of Systems", application.getName());
		assertEquals("catsys", application.getAbbreviationCode());
		assertEquals("Catalog of systems test application", application.getDescription());
		assertEquals("https://github.com/kassiogo/system-catalog", application.getSourceCodeLocationUrl());
	}

	@Test
	void shouldReturnApplicationCreated () {
		var application = new Application();
		application.setName("Catalog of Systems");
		application.setAbbreviationCode("catsys");
		application.setDescription("Catalog of systems test application");
		application.setSourceCodeLocationUrl("https://github.com/kassiogo/system-catalog");
		this.applicationService.save(application);
		
		assertNotNull(application.getId());
		var applicationSaved = this.applicationService.findById(application.getId());
		assertTrue(applicationSaved.isPresent());
		assertEquals(Long.valueOf(1), applicationSaved.get().getId());
	}
	*/
}
