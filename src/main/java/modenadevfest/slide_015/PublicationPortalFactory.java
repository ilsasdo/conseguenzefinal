package modenadevfest.slide_015;

import java.util.List;

public class PublicationPortalFactory {

    private final PortalJpaRepository jpaRepository;

    public PublicationPortalFactory(PortalJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    PublicationPortal subito() {
        PortalEntity portalEntity = jpaRepository.findByCode("subito");
        return new PublicationPortal(
                portalEntity.getCode(),
                portalEntity.getName(),
                List.of(
                        new MustHavePlateNumber(),
                        new MustBeOfMake("Fiat")
                ),
                new CSVFileGenerator(new CustomerFileNamer()),
                new FtpUploader(
                        new FtpSettings(
                                portalEntity.getFtpHost(),
                                portalEntity.getFtpPort(),
                                portalEntity.getFtpUsername(),
                                portalEntity.getPassword())));
    }

    PublicationPortal autoscout24(String code) {
        PortalEntity portaleEntity = jpaRepository.findByCode("subito");
        return new PublicationPortal(
                portaleEntity.getCode(),
                portaleEntity.getName(),
                List.of(
                        new MustBeOfMake("Ferrari")
                ),
                new XMLFileGenerator(new AutoscoutKeyFileNamer()),
                new S3Uploader(portaleEntity.getS3Bucket()));
    }
}
