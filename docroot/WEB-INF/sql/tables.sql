create table MC_Course (
	id_ LONG not null primary key,
	courseId LONG,
	name VARCHAR(75) null,
	siteId LONG
);

create table MC_Host (
	hostId LONG not null primary key,
	siteId LONG,
	remoteSiteId LONG,
	peerId LONG
);

create table MC_Site (
	siteId LONG not null primary key,
	siteName VARCHAR(75) null,
	url VARCHAR(75) null,
	emailDomain VARCHAR(75) null,
	dbServer VARCHAR(75) null,
	dbName VARCHAR(75) null,
	dbUser VARCHAR(75) null,
	dbPass VARCHAR(75) null,
	companyId LONG
);

create table MC_UserEnrollment (
	id_ LONG not null primary key,
	userId LONG,
	courseId LONG,
	lastRefresh DATE null
);