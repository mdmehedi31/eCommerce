package com.ecommerce.dao.definition;

import com.ecommerce.entity.Attachment;

import java.util.List;

public interface AttachmentDao {

    public Long insertAttachment(Attachment attachment);
    public void insertBulkAttachment(List<Attachment> attachments);
    public Attachment findById(Long id);

}
