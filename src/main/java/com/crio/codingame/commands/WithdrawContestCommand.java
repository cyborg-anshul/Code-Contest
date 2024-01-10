package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.entities.RegisterationStatus;
import com.crio.codingame.services.IUserService;

public class WithdrawContestCommand implements ICommand{

    private final IUserService userService;
    
    public WithdrawContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute withdrawContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["WITHDRAW_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        //-
        try{
            String contestId = tokens.get(1);
            String userName = tokens.get(2);
    
            UserRegistrationDto urd=userService.withdrawContest(contestId, userName);

             //Contest contest = contestRepository.findById(contestId).
            // orElseThrow(() -> new ContestNotFoundException("Cannot Attend Contest. Contest for given id:"+contestId+" not found!"));


            // System.out.println("RegisterContestDto [contestName=" + contest.getName() + ", registrationStatus="
            //                     + urd.getRegisterationStatus() + ", userName=" + urd.getUserName() + "]");
            //System.out.println();
            System.out.print(new UserRegistrationDto("Contest#"+tokens.get(1), tokens.get(2), RegisterationStatus.NOT_REGISTERED));

        }
        // 
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        //-
    }
    
}
