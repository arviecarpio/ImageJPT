package ij.parallel.pt;//####[1]####
//####[1]####
import java.util.concurrent.ConcurrentLinkedQueue;//####[3]####
import paratask.runtime.TaskIDGroup;//####[4]####
//####[4]####
//-- ParaTask related imports//####[4]####
import paratask.runtime.*;//####[4]####
import java.util.concurrent.ExecutionException;//####[4]####
import java.util.concurrent.locks.*;//####[4]####
import java.lang.reflect.*;//####[4]####
import javax.swing.SwingUtilities;//####[4]####
//####[4]####
public class ByteProcessorPT {//####[6]####
//####[6]####
    /*  ParaTask helper method to access private/protected slots *///####[6]####
    public void __pt__accessPrivateSlot(Method m, Object instance, TaskID arg, Object interResult ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {//####[6]####
        if (m.getParameterTypes().length == 0)//####[6]####
            m.invoke(instance);//####[6]####
        else if ((m.getParameterTypes().length == 1))//####[6]####
            m.invoke(instance, arg);//####[6]####
        else //####[6]####
            m.invoke(instance, arg, interResult);//####[6]####
    }//####[6]####
//####[8]####
    public ByteProcessorPT() {//####[8]####
    }//####[10]####
//####[15]####
    private Method __pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_method = null;//####[15]####
    private Lock __pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_lock = new ReentrantLock();//####[15]####
    /**
	 * Multi-task paratask
	 *///####[15]####
    private TaskIDGroup<Void> processImagePT_Salt_and_Pepper(ConcurrentLinkedQueue<Runnable> tasks)  {//####[15]####
//####[15]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[15]####
        return processImagePT_Salt_and_Pepper(tasks, new TaskInfo());//####[15]####
    }//####[15]####
    /**
	 * Multi-task paratask
	 *///####[15]####
    private TaskIDGroup<Void> processImagePT_Salt_and_Pepper(ConcurrentLinkedQueue<Runnable> tasks, TaskInfo taskinfo)  {//####[15]####
        if (__pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_method == null) {//####[15]####
            try {//####[15]####
                __pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_lock.lock();//####[15]####
                if (__pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_method == null) //####[15]####
                    __pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_method = ParaTaskHelper.getDeclaredMethod(getClass(), "__pt__processImagePT_Salt_and_Pepper", new Class[] {ConcurrentLinkedQueue.class});//####[15]####
            } catch (Exception e) {//####[15]####
                e.printStackTrace();//####[15]####
            } finally {//####[15]####
                __pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_lock.unlock();//####[15]####
            }//####[15]####
        }//####[15]####
//####[15]####
        Object[] args = new Object[] {tasks};//####[15]####
        taskinfo.setTaskArguments(args);//####[15]####
        taskinfo.setMethod(__pt__processImagePT_Salt_and_Pepper_ConcurrentLinkedQueueRunnable_method);//####[15]####
        taskinfo.setInstance(this);//####[15]####
//####[15]####
        return TaskpoolFactory.getTaskpool().enqueueMulti(taskinfo, -1);//####[15]####
    }//####[15]####
    /**
	 * Multi-task paratask
	 *///####[15]####
    public void __pt__processImagePT_Salt_and_Pepper(ConcurrentLinkedQueue<Runnable> tasks) {//####[15]####
        Runnable t = null;//####[17]####
        while ((t = tasks.poll()) != null) //####[19]####
        {//####[19]####
            processDivPT(t);//####[20]####
        }//####[21]####
    }//####[22]####
//####[22]####
//####[27]####
    /**
	 * Basic task performed
	 *///####[27]####
    private void processDivPT(Runnable task) {//####[27]####
        task.run();//####[28]####
    }//####[29]####
//####[34]####
    /**
	 * Method called by ImageJ
	 *///####[34]####
    public void salt_and_pepper_PARATASK(ConcurrentLinkedQueue<Runnable> tasks) {//####[34]####
        TaskIDGroup idSaltAndPepper = processImagePT_Salt_and_Pepper(tasks);//####[35]####
        try {//####[37]####
            idSaltAndPepper.waitTillFinished();//####[38]####
        } catch (Exception e) {//####[41]####
            e.printStackTrace();//####[42]####
        }//####[43]####
    }//####[44]####
}//####[44]####
