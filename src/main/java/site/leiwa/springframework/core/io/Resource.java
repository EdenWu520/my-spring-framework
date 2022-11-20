package site.leiwa.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 资源加载接口
 * @since 2022/11/20
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
