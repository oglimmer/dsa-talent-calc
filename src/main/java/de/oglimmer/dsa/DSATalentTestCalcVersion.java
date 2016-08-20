package de.oglimmer.dsa;

import java.text.DateFormat;
import java.util.Date;

import com.jcabi.manifests.Manifests;

import lombok.Getter;

public enum DSATalentTestCalcVersion {
	INSTANCE;

	private final String prefix = "dsa-talcalc-core";

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
			commit = Manifests.read(prefix + "-git-commit");
			long time = Long.parseLong(Manifests.read(prefix + "-creation-date"));
			creationDate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(time));
			dsaCalcVersion = Manifests.read(prefix + "-project-version");
		} catch (IllegalArgumentException e) {
			commit = "?";
			creationDate = "?";
			dsaCalcVersion = "?";
		}

		version = "V" + dsaCalcVersion + " [Commit#" + commit + "] build " + creationDate;
	}

}
