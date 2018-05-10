package mail.logging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

/**
 * Class to place <b>log4j</b> logs in <b>ReportNG</b> reports.
 */
public class TestNgReportAppender extends AppenderSkeleton {

    @Override
    protected void append(final LoggingEvent event) {
	String message = layout.format(event);
	Reporter.log(message);
    }

    @Override
    public void close() {
    }

    /**
     * Defines if layout required for <b>log4j</b> logs.
     */
    @Override
    public boolean requiresLayout() {
	return true;
    }
}