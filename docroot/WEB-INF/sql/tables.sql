create table MC_Course (
	id_ LONG not null primary key,
	courseId LONG,
	name VARCHAR(75) null,
	entityId LONG,
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
	entityId LONG,
	remoteEntityId LONG,
	peerId LONG
);

create table MC_UserEnrollment (
	id_ LONG not null primary key,
	userId LONG,
	courseId LONG,
	lastRefresh DATE null
);