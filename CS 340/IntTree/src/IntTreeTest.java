import org.junit.Assert;
import org.junit.Test;
import javax.xml.soap.Node;

import static org.junit.Assert.*;

/**
 * Created by Kenan on 2/26/2018.
 */
public class IntTreeTest {
    @Test
    public void preorder() throws Exception {
        int[] firstArray = {2,5,6};
        IntTree firstChild = new IntTree(firstArray);
        int[] secondArray = {7,12,13};
        IntTree secondChild = new IntTree(3,new IntTree[]{new IntTree(secondArray)});
        int[] thirdArray = {4,8,9,10,11};
        IntTree thirdChild = new IntTree(thirdArray);
        IntTree finalTree = new IntTree(1,new IntTree[]{firstChild,secondChild,thirdChild});
        System.out.println("PreOrder: " + finalTree.preorder());
    }

    @Test
    public void postorder() throws Exception {
        int[] firstArray = {2,5,6};
        IntTree firstChild = new IntTree(firstArray);
        int[] secondArray = {7,12,13};
        IntTree secondChild = new IntTree(3,new IntTree[]{new IntTree(secondArray)});
        int[] thirdArray = {4,8,9,10,11};
        IntTree thirdChild = new IntTree(thirdArray);
        IntTree finalTree = new IntTree(1,new IntTree[]{firstChild,secondChild,thirdChild});
        System.out.println("PostOrder: " + finalTree.postorder());
    }

    @Test
    public void levelorder() throws Exception {
        int[] firstArray = {2,5,6};
        IntTree firstChild = new IntTree(firstArray);
        int[] secondArray = {7,12,13};
        IntTree secondChild = new IntTree(3,new IntTree[]{new IntTree(secondArray)});
        int[] thirdArray = {4,8,9,10,11};
        IntTree thirdChild = new IntTree(thirdArray);
        IntTree finalTree = new IntTree(1,new IntTree[]{firstChild,secondChild,thirdChild});
        System.out.println("LevelOrder: " + finalTree.levelorder());
    }

    @Test
    public void path() throws Exception {
        int[] firstArray = {2,5,6};
        IntTree firstChild = new IntTree(firstArray);
        int[] secondArray = {7,12,13};
        IntTree secondChild = new IntTree(3,new IntTree[]{new IntTree(secondArray)});
        int[] thirdArray = {4,8,9,10,11};
        IntTree thirdChild = new IntTree(thirdArray);
        IntTree finalTree = new IntTree(1,new IntTree[]{firstChild,secondChild,thirdChild});
        String answer = "7,3,2,1";
        assertEquals(answer,finalTree.path(7));
    }

    @Test
    public void count() throws Exception {
        int[] firstArray = {2,5,6};
        IntTree firstChild = new IntTree(firstArray);
        int[] secondArray = {7,12,13};
        IntTree secondChild = new IntTree(3,new IntTree[]{new IntTree(secondArray)});
        int[] thirdArray = {4,8,9,10,11};
        IntTree thirdChild = new IntTree(thirdArray);
        IntTree finalTree = new IntTree(1,new IntTree[]{firstChild,secondChild,thirdChild});
        assertEquals(1,finalTree.count(3));
    }

    @Test
    public void sum() throws Exception {
        int[] firstArray = {2,5,6};
        IntTree firstChild = new IntTree(firstArray);
        int[] secondArray = {7,12,13};
        IntTree secondChild = new IntTree(3,new IntTree[]{new IntTree(secondArray)});
        int[] thirdArray = {4,8,9,10,11};
        IntTree thirdChild = new IntTree(thirdArray);
        IntTree finalTree = new IntTree(1,new IntTree[]{firstChild,secondChild,thirdChild});
        System.out.println("Sum: " + finalTree.sum());
        int compare = finalTree.sum();
        int arraySum = 0;
        for (int aFirstArray : firstArray) {arraySum += aFirstArray;}
        for (int aSecondArray : secondArray) {arraySum += aSecondArray;}
        for (int aThirdArray : thirdArray) {arraySum += aThirdArray;}
        assertEquals(arraySum+4,compare);
    }

}