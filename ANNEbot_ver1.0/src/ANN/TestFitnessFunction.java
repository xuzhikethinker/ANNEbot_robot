/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ANN;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author sulantha
 */
public class TestFitnessFunction extends FitnessFunction{
    @Override
    protected double evaluate(IChromosome ic) {
        double fitness = 100;
        return fitness;
    }
    

}
