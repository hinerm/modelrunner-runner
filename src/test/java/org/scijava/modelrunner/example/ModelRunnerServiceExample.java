
package org.scijava.modelrunner.example;

import io.bioimage.modelrunner.engine.EngineInfo;
import io.bioimage.modelrunner.exceptions.LoadEngineException;
import io.bioimage.modelrunner.model.Model;

import java.io.File;

import org.scijava.Context;
import org.scijava.modelrunner.ModelRunnerService;

public class ModelRunnerServiceExample {

	public static void main(String... strings) {
		// TODO phase 1
		// given a model, request an engine, run the engine on the model
		String modelDir = new File(
			"C:\\Users\\hiner\\Documents\\GitHub\\AI-HT\\model-runner-java\\models")
				.getAbsolutePath();
		String sourceDir = new File(modelDir,
			"EnhancerMitochondriaEM2D_13012023_130426").getAbsolutePath();
		String modelSource = new File(sourceDir, "weights-torchscript.pt")
			.getAbsolutePath();

		System.out.println(modelSource);
		try (Context c = new Context()) {
			ModelRunnerService mlService = c.service(ModelRunnerService.class);
			// TODO add api to mlService to get an engine for a particular engine,
			// cpu, gpu combination?

			// TODO
			// Change to handler plugins and add api for supporting requests
			mlService.getEngines().forEach(e -> {
				try {
					loadModel(sourceDir, modelSource, e.createEngineInfo());
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			});
		}

		// TODO
		// convert other json entries to plugins

		// TODO
		// run models directly from modelzoo
	}

	public static EngineInfo createEngineInfo(String engine, String engineVersion,
		String enginesDir, boolean cpu, boolean gpu)
	{
		// FIXME move to ABstractplugin
		return EngineInfo.defineDLEngine(engine, engineVersion, enginesDir, cpu,
			gpu);
	}

	public static Model loadModel(String modelFolder, String modelSource,
		EngineInfo engineInfo) throws LoadEngineException, Exception
	{
		Model model = Model.createDeepLearningModel(modelFolder, modelSource,
			engineInfo);
		model.loadModel();
		return model;
	}
}
