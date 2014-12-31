package de.oglimmer.dsa;

import java.text.DateFormat;
import java.util.Date;

import lombok.Getter;

import com.jcabi.manifests.Manifests;

public enum DSATalentTestCalcVersion {
	INSTANCE;

	private final String prefix = "DSA-TalCalc";

	@Getter
	private String version;
	@Getter
	private String commit;
	@Getter
	private String dsaCalcVersion;
	@Getter
	private String creationDate;

	private DSATalentTestCalcVersion() {

		try {
			commit = Manifests.read(prefix + "-Git-Commit");
			long time = Long.parseLong(Manifests.read(prefix + "-Creation-Date"));
			creationDate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(time));
			dsaCalcVersion = Manifests.read(prefix + "-Version");
		} catch (IllegalArgumentException e) {
			commit = "?";
			creationDate = "?";
			dsaCalcVersion = "?";
		}

		version = "V" + dsaCalcVersion + " [Commit#" + commit + "] build " + creationDate;
	}

}
