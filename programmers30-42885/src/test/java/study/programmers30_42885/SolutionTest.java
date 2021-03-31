package study.programmers30_42885;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource(value = {
		"70,50,80,50;100;3",
		"70,80,50;100;3"
	}, delimiterString = ";")
	void solution(
		@ConvertWith(IntArrayConverter.class) int[] input,
		int limit, int expect
	) {
		Solution solution = new Solution();
		int answer = solution.solution(input, limit);
		assertEquals(expect, answer);
	}
}

class IntArrayConverter implements ArgumentConverter {

	@Override
	public Object convert(Object source, ParameterContext context)
		throws ArgumentConversionException {
		if (!(source instanceof String)) {
			throw new IllegalArgumentException(
				"The argument should be a string: " + source);
		}
		try {
			return Arrays.stream(((String) source).split(",")).mapToInt(Integer::parseInt)
				.toArray();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Failed to convert", e);
		}
	}
}