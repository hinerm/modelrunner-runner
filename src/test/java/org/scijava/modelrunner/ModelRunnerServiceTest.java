
package org.scijava.modelrunner;

import org.junit.Test;
import org.scijava.Context;

public class ModelRunnerServiceTest {

	@Test
	public void testModelRunner() {
		try (Context c = new Context()) {
			ModelRunnerService mlService = c.service(ModelRunnerService.class);

			mlService.getEngines().forEach(System.out::println);
		}
	}
}
