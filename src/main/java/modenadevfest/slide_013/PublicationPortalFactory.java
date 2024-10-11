package modenadevfest.slide_013;

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
                new FtpUploader(
                        new FtpSettings(
                                portalEntity.getFtpHost(),
                                portalEntity.getFtpPort(),
                                portalEntity.getFtpUsername(),
                                portalEntity.getPassword())));
    }

    PublicationPortal autoscout24(String code) {
        PortalEntity portaleEntity = jpaRepository.findByCode("subito");
        return new PublicationPortal(portaleEntity.getCode(), portaleEntity.getName(),
                new S3Uploader(portaleEntity.getS3Bucket()));
    }
}
