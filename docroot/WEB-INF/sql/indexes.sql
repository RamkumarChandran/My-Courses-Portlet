create index IX_1A6E8826 on MC_Course (courseId, entityId);
create index IX_B4A6051C on MC_Course (entityId);

create index IX_FDF7CA39 on MC_Entity (emailDomains);
create index IX_A0207F8D on MC_Entity (url);

create index IX_3BFA5AA1 on MC_Host (entityId, remoteEntityId);

create index IX_9006F768 on MC_UserEnrollment (courseId);
create index IX_4CED5E37 on MC_UserEnrollment (lastRefresh);
create index IX_88777318 on MC_UserEnrollment (userId);