/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ANN;

import EvolutionaryAlgo.EvolutionManager;
import java.util.Random;

/**
 *
 * @author dilmi
 */
public class ANNTrainer {

    int DEBUG = 0;

    ANN ann;
    EvolutionManager eMan = new EvolutionManager();
    int popCount = 0;
    int genCount = 0;
    ANN temp;

    public ANNTrainer(int numInputNeurons , int hLCount, int numOutputNeurons) {
        this.ann = new ANN(numInputNeurons , hLCount, numOutputNeurons);
    }
    
    public void train(){
        for(;;){
            if(DEBUG == 1){
                System.out.println("Begining of method train()");
                this.ann.getWeights().printMatrix();
                System.out.println("passed to eman");
            }
            
            temp = eMan.evolveANN(this.ann, this.popCount);

            if(DEBUG == 1){
                System.out.println("Got from EvoMan to train() method");
                temp.getWeights().printMatrix();
                System.out.println("---------------");
            }

            this.genCount = eMan.getGenCount();
            this.setFitness(temp);
            ann = temp;
            this.popCount++;
        }    
    }

    private void setFitness(ANN myANN){
        if(this.genCount<10)
            myANN.setFitness((Math.random()*100)%10);
        
        else if(this.genCount <= 10 && this.genCount < 20)
            myANN.setFitness(10+(Math.random()*100)%10);
        
        else if(this.genCount <= 20 && this.genCount < 30)
            myANN.setFitness(20+(Math.random()*100)%10);

        else
            myANN.setFitness(30+(Math.random()*100)%10);
    }
 }

    

   
    

