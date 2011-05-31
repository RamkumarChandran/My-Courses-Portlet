create table MC_Course (
	courseId LONG not null primary key,
	name VARCHAR(75) null,
	lastRefresh LONG
);

create table MC_Entity (
	entityId LONG not null primary key,
	entityName VARCHAR(75) null,
	url VARCHAR(75) null,
	emailDomains VARCHAR(75) null,
	dbName VARCHAR(75) null
);

create table MC_Host (
	hostId LONG not null primary key,
	localEntityId LONG,
	remoteEntityId LONG,
	peerId LONG
);

create table MC_UserEnrollment (
	Id LONG not null primary key,
	userId LONG,
	lastRefresh DATE null
);