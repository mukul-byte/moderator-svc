Interview Assignment - Moderator Assignment for Report Section
Objective:
Design and implement a system to manage and assign tasks to moderators working in different departments. The system should allow
various assignment strategies, monitoring, and administrative controls.
Requirements:
1. Moderators:
a. Moderators can have attributes such as:
id
name
email
departments
preferred_language
shift_timing
preformance_score - can be between 0-10 and will be given by Admin
preferred_city
absent
active
2. Assignment tasks:
Our Jobseeker can report on a job. We have to assign these reports to moderators.
Reports have attributes such as:
id
report_reason_id - report reasons are mentioned below
job_id
reported_by - Jobseeker ID
Report Reasons -
Ask for Money
HR Misbehaved
Incorrect Job Information
No Response from HR
Others (Open text field)
3. Assignment Strategies:
Implement various assignment strategies:
Round Robin: Assign tasks in a circular order to all moderators.
Weighted Round Robin: Assign tasks based on weights assigned to moderators.
Performance-Based: Assign tasks based on the performance scores of moderators.
4. Assignment Filters:
a. Time-Based: Assign tasks considering the time and availability of moderators.
b. Absenteeism: Ensure tasks are not assigned to absent moderators.
c. City-Based: Ensure tasks are assigned to city moderators if available.
5. Administrative Controls:
Admin can:
Monitor the flow of tasks assigned to each moderator.
Mark moderators as absent.
Change the preferred language, shift timing of moderators.
Adjust weights for weighted round-robin assignment.
Provide a dashboard for admins to view and modify these attributes.
Tasks:
1. Design a Class Diagram:
Create a class diagram that includes the following entities and their relationships:
Moderator
Task
Admin
AssignmentStrategy (with different strategy implementations)
2. Moderator assignment system -
a. Implement the assignment strategies and ensure tasks can be assigned based on the selected strategy.
b. APIs -
i. To report a job
ii. Monitoring of report inflow for Admin
iii. Update Moderator attributes i.e. language, assignment weights, city, etc.
c. The system should be DB/Caching driven.
d. Pagination should be implemented wherever required.
e. Proper validation should be in place
3. Test Cases (Optional):
Write test cases to verify the correct functioning of each assignment strategy.
Ensure the admin functionalities are working as expected.
Deliverables:
1. Class Diagram (in a PDF or image format).
2. Source code (Git repository link).
3. Test cases and their results. (Optional)
