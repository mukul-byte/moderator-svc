package assignment.moderator.services;

import assignment.moderator.models.ReportReason;
import assignment.moderator.repositories.ReportReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportReasonService {
    @Autowired
    private ReportReasonRepository reportReasonRepository;

    public ReportReason createOrGetByReportReason(String reportReason){
        Optional<ReportReason> reason = this.reportReasonRepository.findOneByReason(reportReason.toLowerCase());
        if(reason.isPresent()){
            return reason.get();
        }
        ReportReason newReportReason = new ReportReason(reportReason.toLowerCase());
        return this.reportReasonRepository.save(newReportReason);
    }
}
