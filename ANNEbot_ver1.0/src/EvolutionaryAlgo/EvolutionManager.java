/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EvolutionaryAlgo;
import Utility.*;
import ANN.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sulantha
 */
public class EvolutionManager {

    int DEBUG = 1;
    
    int populationSize = 10;
    int genomeIndex = 0;
    ArrayList<Genome> oldPopulation = new ArrayList<Genome>();
    ArrayList<Genome> newPopulation = new ArrayList<Genome>();

    GeneticAlgorithm genAlgo = new GeneticAlgorithm();
    int genCount;

    public int getGenCount() {
        return genCount;
    }

    


    Genome createGenome(Matrix weights, double fitness){
        return new Genome(weights, fitness);
    }

    public ANN evolveANN(ANN oldANN, int popCount){
        if(DEBUG == 1){
            System.out.println("Evolve comm recieved. Population Count : " + popCount);
        }
        if (popCount == 0){
            createInitialPopulation(oldANN.getWeights().getNumOfCols());
            Matrix newWeights = oldPopulation.get(genomeIndex).weightMatrix;
            double newFitness = oldPopulation.get(genomeIndex).fitnessValue;
            oldANN.setWeights(newWeights);
            oldANN.setFitness(newFitness);
            genomeIndex++;

        }else{
            if (newPopulation.size() == populationSize){
                oldPopulation = genAlgo.getNewPopulation(newPopulation);
                newPopulation = new ArrayList<Genome>();
                genomeIndex = 0;
                genCount++;
            }
            Matrix oldWeights = oldANN.getWeights();
            double oldFitness = oldANN.getFitness();
            Genome genomeFromOldData = createGenome(oldWeights, oldFitness);
            newPopulation.add(genomeFromOldData);
            Matrix newWeights = oldPopulation.get(genomeIndex).weightMatrix;
            double newFitness = oldPopulation.get(genomeIndex).fitnessValue;
            oldANN.setWeights(newWeights);
            oldANN.setFitness(newFitness);
            genomeIndex++;

        }
        if(DEBUG == 1){
            System.out.println("newPopulation var " + popCount);
        }
        return oldANN;
    }


    private void createInitialPopulation(int matrixSize) {
        for(int i = 0; i<populationSize;i++){
            Random rand = new Random();
            Matrix weightMatrix = new Matrix(1, matrixSize);
            for (int j = 0; j < matrixSize ; j++){
                double initWeights = rand.nextDouble();
                weightMatrix.set(0, j, initWeights);
                
            }
            oldPopulation.add(new Genome(weightMatrix));
        }
    }




}
