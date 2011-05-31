create index IX_FDF7CA39 on MC_Entity (emailDomains);
create index IX_A0207F8D on MC_Entity (url);

create index IX_34590B5A on MC_Host (localEntityId, remoteEntityId);

create index IX_4CED5E37 on MC_UserEnrollment (lastRefresh);
create index IX_88777318 on MC_UserEnrollment (userId);