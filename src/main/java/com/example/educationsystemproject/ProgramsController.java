package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/programs", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProgramsController {
    @Autowired
    private ProgramsRepository programsRepository;

    @PostMapping("/add")
    public String addEnrollment(@RequestParam String programName,
                                @RequestParam String campus) {
        Programs programs = new Programs();
        programs.setProgramName(programName);
        programs.setCampus(campus);
        programsRepository.save(programs);
        return "Added new enrollment to database!";
    }

    @GetMapping("/list")
    public Iterable<Programs> getPrograms() {
        return programsRepository.findAll();
    }
    @GetMapping("/view/{pid}")
    public Programs findProgramsBypid(@PathVariable Integer pid) {
        return programsRepository.findProgramsBypid(pid);
    }
    @DeleteMapping("/delete/{pid}")
    public String deleteProgramBypid(@PathVariable("pid") Integer pid) {
        programsRepository.deleteById(pid);
        return "Program deleted from database";
    }
    @PutMapping("/modify/{pid}")
    public String updateProgramBypid(@PathVariable("pid") Integer pid,
                                        @RequestParam String programName,
                                        @RequestParam String campus) {
        Programs programs = programsRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id: "+pid));
        programs.setProgramName(programName);
        programs.setCampus(campus);
        programsRepository.save(programs);
        return "Updated Programs!";
    }
}
