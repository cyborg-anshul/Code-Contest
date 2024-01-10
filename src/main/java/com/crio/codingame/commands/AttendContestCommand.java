package com.crio.codingame.commands;

import java.util.List;
import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.RegisterationStatus;
import com.crio.codingame.repositories.IContestRepository;
import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.services.IUserService;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidOperationException;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;
    private final IContestRepository contestRepository;
    
    public AttendContestCommand(IUserService userService,IContestRepository contestRepository) {
        this.userService = userService;
        this.contestRepository = contestRepository;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute attendContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["ATTEND_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        try{
            String contestId = tokens.get(1);
            String userName = tokens.get(2);
    
            UserRegistrationDto urd=userService.attendContest(contestId, userName);

             //Contest contest = contestRepository.findById(contestId).
            // orElseThrow(() -> new ContestNotFoundException("Cannot Attend Contest. Contest for given id:"+contestId+" not found!"));


            // System.out.println("RegisterContestDto [contestName=" + contest.getName() + ", registrationStatus="
            //                     + urd.getRegisterationStatus() + ", userName=" + urd.getUserName() + "]");
            //System.out.println();
            System.out.print(new UserRegistrationDto("Contest#"+tokens.get(1), tokens.get(2), RegisterationStatus.REGISTERED));

        }
        // 
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
