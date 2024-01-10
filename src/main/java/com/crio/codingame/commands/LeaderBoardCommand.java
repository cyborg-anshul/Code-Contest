package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.entities.User;
import com.crio.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        if(tokens.size()==1){
            List<User> urs = userService.getAllUserScoreOrderWise(null);
            System.out.println(urs);
            return;}

        ScoreOrder scoreOrder= ScoreOrder.valueOf(tokens.get(1));
        List<User> urs = userService.getAllUserScoreOrderWise(scoreOrder);
        System.out.println(urs);
        
        // for (User user : urs) {
        //     stringJoiner.add(user.toString());
        //     // System.out.println("Username: " + user.getName() + ", Score: " + user.getScore());
        //     // System.out.print(new UserRegistrationDto("Contest#"+tokens.get(1), tokens.get(2), RegisterationStatus.REGISTERED));
        //     // System.out.println("[User [id=" + user.getId()+ ", contests="+ user.getContests() +", name="
        //     // + user.getName()+ ", score=" + user.getScore() +"]
        // }
        // System.out.println("Leaderboard: " + stringJoiner.toString());

    }
    
}
