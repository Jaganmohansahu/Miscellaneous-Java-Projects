package model;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;

public class SpeechRecognizerMain {
	
	// Necessary
	private LiveSpeechRecognizer recognizer;
	
	//Robot class
	private Robot r;
	// Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * This String contains the Result that is coming back from SpeechRecognizer
	 */
	private String speechRecognitionResult;
	
	//-----------------Lock Variables-----------------------------
	
	/**
	 * This variable is used to ignore the results of speech recognition cause actually it can't be stopped...
	 * 
	 * <br>
	 * Check this link for more information: <a href=
	 * "https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/">https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/</a>
	 */
	private boolean ignoreSpeechRecognitionResults = false;
	
	/**
	 * Checks if the speech recognise is already running
	 */
	private boolean speechRecognizerThreadRunning = false;
	
	/**
	 * Checks if the resources Thread is already running
	 */
	private boolean resourcesThreadRunning;
	
	//---
	
	/**
	 * This executor service is used in order the playerState events to be executed in an order
	 */
	private ExecutorService eventsExecutorService = Executors.newFixedThreadPool(2);
	
	//------------------------------------------------------------------------------------
	
	/**
	 * Constructor
	 */
	public SpeechRecognizerMain() {
		
		// Loading Message
		logger.log(Level.INFO, "Loading Speech Recognizer...\n");
		
		// Configuration
		Configuration configuration = new Configuration();
		
		// Load model from the jar
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		
		//====================================================================================
		//=====================READ THIS!!!===============================================
		//Uncomment this line of code if you want the recognizer to recognize every word of the language 
		//you are using , here it is English for example	
		//====================================================================================
		//configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		
		//====================================================================================
		//=====================READ THIS!!!===============================================
		//If you don't want to use a grammar file comment below 3 lines and uncomment the above line for language model	
		//====================================================================================
		
		// Grammar
		configuration.setGrammarPath("resource:/grammars");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);
		
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
		
		// Start recognition process pruning previously cached data.
		// recognizer.startRecognition(true);
		
		//Check if needed resources are available
		startResourcesThread();
		//Start speech recognition thread
		startSpeechRecognition();
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Starts the Speech Recognition Thread
	 */
	public synchronized void startSpeechRecognition() {
		
		//Check lock
		if (speechRecognizerThreadRunning)
			logger.log(Level.INFO, "Speech Recognition Thread already running...\n");
		else
			//Submit to ExecutorService
			eventsExecutorService.submit(() -> {
				
				//locks
				speechRecognizerThreadRunning = true;
				ignoreSpeechRecognitionResults = false;
				
				//Start Recognition
				recognizer.startRecognition(true);
				
				//Information			
				logger.log(Level.INFO, "You can start to speak...\n");
				
				try {
					while (speechRecognizerThreadRunning) {
						/*
						 * This method will return when the end of speech is reached. Note that the end pointer will determine the end of speech.
						 */
						SpeechResult speechResult = recognizer.getResult();
						
						//Check if we ignore the speech recognition results
if (!ignoreSpeechRecognitionResults) {
							
							//Check the result
							if (speechResult == null)
								logger.log(Level.INFO, "I can't understand what you said.\n");
							else {
								
								//Get the hypothesis
								speechRecognitionResult = speechResult.getHypothesis();
								
								//You said?
								System.out.println("You said: [" + speechRecognitionResult + "]\n");
								
								//Call the appropriate method 
								makeDecision(speechRecognitionResult, speechResult.getWords());
								
							//Program to shutdown computer
								String str = "open notepad";
								String str1 = "test";
								String str2 = "hello java";
								String str3 = "close notepad";
								String str4 = "maximize notepad";
								String str5 = "minimize notepad";
								String str6 = "write";
								try {
									r = new Robot();
								}
								catch(Exception e) {}
								if(speechRecognitionResult.equals(str))
								{
									  r.mouseMove(12, 747);
									    r.mousePress(InputEvent.BUTTON1_MASK);
										r.mouseRelease(InputEvent.BUTTON1_MASK);
										r.setAutoDelay(2000);
										r.mouseMove(330, 360);
									    r.mousePress(InputEvent.BUTTON1_MASK);
										r.mouseRelease(InputEvent.BUTTON1_MASK);
								}
								if(speechRecognitionResult.equals(str6))
									{
										r.keyPress(KeyEvent.VK_SHIFT);
										r.keyPress(KeyEvent.VK_P);
										r.keyPress(KeyEvent.VK_R);
										r.keyPress(KeyEvent.VK_I);
										r.keyPress(KeyEvent.VK_N);
										r.keyPress(KeyEvent.VK_T);
										r.keyPress(KeyEvent.VK_I);
										r.keyPress(KeyEvent.VK_N);
										r.keyPress(KeyEvent.VK_G);
										r.keyPress(KeyEvent.VK_SPACE);	
										r.keyPress(KeyEvent.VK_M);
										r.keyPress(KeyEvent.VK_E);
										r.keyPress(KeyEvent.VK_S);
										r.keyPress(KeyEvent.VK_S);
										r.keyPress(KeyEvent.VK_A);
										r.keyPress(KeyEvent.VK_G);
										r.keyPress(KeyEvent.VK_E);
										r.keyPress(KeyEvent.VK_S);
										r.keyPress(KeyEvent.VK_SPACE);
										r.keyPress(KeyEvent.VK_W);
										r.keyPress(KeyEvent.VK_I);
										r.keyPress(KeyEvent.VK_T);
										r.keyPress(KeyEvent.VK_H);
										r.keyPress(KeyEvent.VK_O);
										r.keyPress(KeyEvent.VK_U);
										r.keyPress(KeyEvent.VK_T);
										r.keyPress(KeyEvent.VK_SPACE);
										r.keyPress(KeyEvent.VK_T);
										r.keyPress(KeyEvent.VK_O);
										r.keyPress(KeyEvent.VK_U);
										r.keyPress(KeyEvent.VK_C);
										r.keyPress(KeyEvent.VK_H);
										r.keyPress(KeyEvent.VK_I);
										r.keyPress(KeyEvent.VK_N);
										r.keyPress(KeyEvent.VK_G);
										r.keyPress(KeyEvent.VK_SPACE);
										r.keyPress(KeyEvent.VK_K);
										r.keyPress(KeyEvent.VK_E);
										r.keyPress(KeyEvent.VK_Y);
										r.keyPress(KeyEvent.VK_B);
										r.keyPress(KeyEvent.VK_O);
										r.keyPress(KeyEvent.VK_A);
										r.keyPress(KeyEvent.VK_R);
										r.keyPress(KeyEvent.VK_D);
										r.keyPress(KeyEvent.VK_ENTER);
								}
								if(speechRecognitionResult.equals(str1))
								{
									r.keyPress(KeyEvent.VK_T);
									r.keyPress(KeyEvent.VK_E);
									r.keyPress(KeyEvent.VK_S);
									r.keyPress(KeyEvent.VK_T);
									r.keyPress(KeyEvent.VK_ENTER);
								}
								if(speechRecognitionResult.equals(str2))
								{
									
									r.keyPress(KeyEvent.VK_H);
									r.keyPress(KeyEvent.VK_E);
									r.keyPress(KeyEvent.VK_L);
									r.keyPress(KeyEvent.VK_L);
									r.keyPress(KeyEvent.VK_O);
									r.keyPress(KeyEvent.VK_SPACE);
									r.keyPress(KeyEvent.VK_SHIFT);
									r.keyPress(KeyEvent.VK_J);
									r.keyPress(KeyEvent.VK_A);
									r.keyPress(KeyEvent.VK_V);
									r.keyPress(KeyEvent.VK_A);
									r.keyPress(KeyEvent.VK_ENTER);
								}
								if(speechRecognitionResult.equals(str3))
								{
									 r.mouseMove(1058, 243);
									 r.mousePress(InputEvent.BUTTON1_MASK);
									 r.mouseRelease(InputEvent.BUTTON1_MASK);
								}
								if(speechRecognitionResult.equals(str4))
								{
									 r.mouseMove(1015, 264);
									 r.mousePress(InputEvent.BUTTON1_MASK);
									 r.mouseRelease(InputEvent.BUTTON1_MASK);
								}
								if(speechRecognitionResult.equals(str5))
								{
									 r.mouseMove(1287, 8);
									 r.mousePress(InputEvent.BUTTON1_MASK);
									 r.mouseRelease(InputEvent.BUTTON1_MASK);
								}
								
								//You said?
								System.out.println("You said: [" + speechRecognitionResult + "]\n");
								
								//Call the appropriate method 
								makeDecision(speechRecognitionResult, speechResult.getWords());
								
							}
						} else
							logger.log(Level.INFO, "Ignoring Speech Recognition Results...");
						
					}
				} catch (Exception ex) {
					logger.log(Level.WARNING, null, ex);
					speechRecognizerThreadRunning = false;
				}
				
				logger.log(Level.INFO, "SpeechThread has exited...");
				
			});
	}
	
	/**
	 * Stops ignoring the results of SpeechRecognition
	 */
	public synchronized void stopIgnoreSpeechRecognitionResults() {
		
		//Stop ignoring speech recognition results
		ignoreSpeechRecognitionResults = false;
	}
	
	/**
	 * Ignores the results of SpeechRecognition
	 */
	public synchronized void ignoreSpeechRecognitionResults() {
		
		//Instead of stopping the speech recognition we are ignoring it's results
		ignoreSpeechRecognitionResults = true;
		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Starting a Thread that checks if the resources needed to the SpeechRecognition library are available
	 */
	public void startResourcesThread() {
		
		//Check lock
		if (resourcesThreadRunning)
			logger.log(Level.INFO, "Resources Thread already running...\n");
		else
			//Submit to ExecutorService
			eventsExecutorService.submit(() -> {
				try {
					
					//Lock
					resourcesThreadRunning = true;
					
					// Detect if the microphone is available
					while (true) {
						
						//Is the Microphone Available
						if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE))
							logger.log(Level.INFO, "Microphone is not available.\n");
						
						// Sleep some period
						Thread.sleep(350);
					}
					
				} catch (InterruptedException ex) {
					logger.log(Level.WARNING, null, ex);
					resourcesThreadRunning = false;
				}
			});
	}
	
	/**
	 * Takes a decision based on the given result
	 * 
	 * @param speechWords
	 */
	public void makeDecision(String speech , List<WordResult> speechWords) {
		
		System.out.println(speech);
		
	}
	
	public boolean getIgnoreSpeechRecognitionResults() {
		return ignoreSpeechRecognitionResults;
	}
	
	public boolean getSpeechRecognizerThreadRunning() {
		return speechRecognizerThreadRunning;
	}
	
	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new SpeechRecognizerMain();
	}
}