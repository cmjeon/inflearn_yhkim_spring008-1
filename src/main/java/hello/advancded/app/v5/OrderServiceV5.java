package hello.advancded.app.v5;

import hello.advancded.trace.callback.TraceCallback;
import hello.advancded.trace.callback.TraceTemplate;
import hello.advancded.trace.logtrace.LogTrace;
import hello.advancded.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;

    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.excute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }

}
