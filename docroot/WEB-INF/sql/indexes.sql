create index IX_EBDFBF0A on MC_Course (courseId, siteId);
create index IX_BC9E0180 on MC_Course (siteId);

create index IX_56AE70E9 on MC_Host (siteId, remoteSiteId);

create index IX_D70BAE32 on MC_Site (companyId);
create index IX_E824573A on MC_Site (emailDomain);
create index IX_C1BA7D69 on MC_Site (url);

create index IX_9006F768 on MC_UserEnrollment (courseId);
create index IX_4CED5E37 on MC_UserEnrollment (lastRefresh);
create index IX_88777318 on MC_UserEnrollment (userId);
create index IX_48DC9122 on MC_UserEnrollment (userId, courseId);