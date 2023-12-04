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
    public Programs addEnrollment(@RequestBody Programs programs) {
        return programsRepository.save(programs);
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
    public Programs updateProgramBypid(@PathVariable("pid") Integer pid,
                                        @RequestBody Programs programs) {
        Programs updatedPrograms;
        updatedPrograms = programs;
        programs = programsRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id: "+pid));
        programs.setProgramName(updatedPrograms.getProgramName());
        programs.setCampus(updatedPrograms.getCampus());
        return programsRepository.save(programs);
    }
}
