package io.github.batenzar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author batenzar
 *
 */
public class Main {
	
	private static final String DEFAULT_DIR = "D:\\log_com_usage\\output\\";

	public static void main(String[] args) throws IOException {
		String dir = DEFAULT_DIR;
		if (args.length > 0) {
			dir = args[0];
		}

		boolean logon = true;
		String targetFile = "logon.log";
		if (args.length > 1) {
			logon = Boolean.parseBoolean(args[1]);

			if (!logon) {
				targetFile = "logoff.log";
			}
		}

		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();

		// output
		Path dateDir = Paths.get(dir, String.valueOf(localDate));
		if (Files.notExists(dateDir)) {
			Files.createDirectories(dateDir);
		}

		// output/log
		Path logFile = Paths.get(dateDir.toString(), "log.txt");
		if (Files.notExists(logFile)) {
			Files.createFile(logFile);
		}
		List<String> log = Files.readAllLines(logFile);
		log.add("localDate:" + localDate + ", localTime: " + localTime + ", logon: " + logon);
		Files.write(logFile, log);

		// output/log on|log off
		Path outputFile = Paths.get(dateDir.toString(), targetFile);
		if (Files.notExists(outputFile)) {
			Files.createFile(outputFile);
		}

		List<String> content = Files.readAllLines(outputFile);
		if (content.size() > 0) {
			LocalTime contentTime = LocalTime.parse(content.get(0));
			if ((logon && localTime.isAfter(contentTime)) || (!logon && localTime.isBefore(contentTime))) {
				// do nothing
				return;
			}
			writeTime(localTime, outputFile);
		} else {
			writeTime(localTime, outputFile);
		}

	}

	private static void writeTime(LocalTime localTime, Path path) throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add(String.valueOf(localTime));
		Files.write(path, lines);
	}
}