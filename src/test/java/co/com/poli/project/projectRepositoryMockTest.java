package co.com.poli.project;


import co.com.poli.project.domain.Project;
import co.com.poli.project.repository.IProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class projectRepositoryMockTest {


    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void when_Insert_Project_then_ReturnListProject(){
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("Proyecto_2");
        project.setProjectIdentifier("ADSA48");
        project.setDescription("Proyecto de prueba 2");
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setBacklog(null);

        projectRepository.save(project);

        Project project2 = new Project();
        project2.setId(12L);
        project2.setProjectName("Proyecto_3");
        project2.setProjectIdentifier("ADeA48");
        project2.setDescription("Proyecto de prueba 3");
        project2.setStartDate(new Date());
        project2.setEndDate(new Date());
        project2.setBacklog(null);

        projectRepository.save(project2);

        List<Project> projectList =projectRepository.findAll();


        Assertions.assertThat(projectList.size()).isEqualTo(4);

    }

}
