package com.alexapps.whichanimalareyou.model;

import com.alexapps.whichanimalareyou.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class Prompter {
    private Animal[] mAnimals;
    private List <Statement> mStatementList;
    private Statement mCurrentStatement;
    private Map <String, Integer> mUserAnswers;
    public Prompter () {
        mUserAnswers = new TreeMap<>();
        mAnimals = new Animal[10];
        Statement[] statements = new Statement[10];
        statements[0] = new Statement("air",
                "You adore travelling by plane and can’t understand people, who’re trembling in fear at take off and landing. What can be better than view clear blue sky at 10 000 meter high?");
        statements[1] = new Statement ("beauty",
                "People often say that you look great, and you even catch the views of unfamiliar people, who admire your beauty.");
        statements[2] = new Statement ("honest",
                "Usually it’s hard for you to lie to a person, even if it can bring some benefit to you. You prefer to say what you think and don’t like to hide thoughts.");
        statements[3] = new Statement ("muscles",
                "You are quite sportive, don’t have excess weight and can easily run couple of miles. To live week of your life without doing sports is unusually for you.");
        statements[4] = new Statement ("peaceful",
                "You belive, that people should become more peaceful, cease struggling with each other and stop wars . If you get to the conflict with the stranger, you most likely will concede and try to stop conflict.");
        statements[5] = new Statement ("predator",
                "Meat is definitely best food for you. You can live without any food, but you can’t abandon eating meat. Vegetarians seem crazy people for you.");
        statements[6] = new Statement ("smart",
                "You like to learn and easily remember new information. You also enjoy solving puzzles and find answers on complex questions.");
        statements[7] = new Statement ("social",
                "You like to meet new people, there are so much interesting persons in the world! You can easily talk to a stranger without any reason.");
        statements[8] = new Statement ("sweetHome",
                "You don’t like travel too much. What can be better, than  sit with your favorite book in the soft chair at home?");
        statements[9] = new Statement ("water",
                "You like visiting swimming pools, and feel free to swim far away in the sea. You’ve mastered more than one style of swimming.");
        mStatementList = new ArrayList <Statement>(Arrays.asList(statements));
        // airborne, beatiful, honest, muscles, peaceful, predator, smart, social,  sweethome, water
        // if negative number - feature should be not more than that number
        int[] sharkArray = {0,2,0,4,-2,5,0,0,-2,5};
        mAnimals[0]= new Animal ("shark",
                R.drawable.shark,
                sharkArray);
        int[] bearArray = {0,2,0,5,-1,5,0,0,4,0};
        mAnimals[1]= new Animal ("bear",
                R.drawable.bear,
                bearArray);
        int[] dolphinArray = {0,4,3,4,4,-3,5,4,0,5};
        mAnimals[2]= new Animal ("dolphin",
                R.drawable.dolphin,
                dolphinArray);
        int[] eagleArray = {5,4,0,4,-3,4,3,0,-3,0};
        mAnimals[3]= new Animal ("eagle",
                R.drawable.eagle,
                eagleArray);
        int[] tigerArray = {0,3,0,4,-2,4,3,2,3,0};
        mAnimals[4]= new Animal ("tiger",
                R.drawable.tiger,
                tigerArray);
        int[] elephantArray = {0,3,4,4,3,-3,4,4,3,0};
        mAnimals[5]= new Animal ("elephant",
                R.drawable.elephant,
                elephantArray);
        int[] monkeyArray = {0,0,-3,2,0,-3,3,4,3,0};
        mAnimals[6]= new Animal ("monkey",
                R.drawable.monkey,
                monkeyArray);
        int [] pandaArray = {0,4,3,0,3,-3,0,0,3,0};
        mAnimals[7]= new Animal ("red panda",
                R.drawable.redpanda,
                pandaArray);
        int[] penguinArray = {0,2,0,2,3,0,0,4,0,4};
        mAnimals[8]= new Animal ("penguin",
                R.drawable.penguin,
                penguinArray);
        int [] turtleArray = {0,0,0,0,0,0,0,0,0,0};
        mAnimals[9]= new Animal ("turtle",
                R.drawable.turtle,
                turtleArray);
    }

    public String askQuestion () {
        int size = mStatementList.size();
        if (size == 1) {
            mCurrentStatement = mStatementList.get(0);
            mCurrentStatement.setFinal(true);
            return mCurrentStatement.getStatement();
        }
        Random random = new Random();
        int randomNumber = random.nextInt(size);
        mCurrentStatement = mStatementList.get(randomNumber);
        mStatementList.remove(randomNumber);
        return mCurrentStatement.getStatement();
    };

    public void saveAnswer (int userAnswer) {
    String feature = mCurrentStatement.getFeature();
    mUserAnswers.put(feature,userAnswer);
    }

    public boolean isFinal () {
        return mCurrentStatement.isFinal();
    }

    public Animal detectAnimal (){
        List <Integer> userChoices = (List<Integer>) mUserAnswers.values();
        for (Animal animal:mAnimals) {
            boolean flag = true;
            int [] features = animal.getFeatures();
            int count = 0;
            for (int feature:features){
                 if ((feature < 0)&(userChoices.get(count) > feature*(-1))) {
                    flag = false;
                    }
                 if ((feature > 0) & (userChoices.get(count)<feature)) {
                     flag = false;
                 }
                count++;
            }
        if (flag) {return animal;}

        }
        return mAnimals[9];
    }

}








