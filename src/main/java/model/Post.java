package model;

import java.util.List;

public record Post(
        long id,
        String title,
        String body,
        long userId,
        List<String> tags,
        long reactions,

        /** Time of publishing in ISO format, for example "2023-04-10T09:45:00Z" */
        String publishedAt,

        /**
         * Optional time of deletion in ISO format, for example "2023-04-10T09:45:00Z"
         */
        String deletedAt) {
}
