#include<stdlib.h>
 main()
{
	void *vm_mem;

	kvm = kvm_init(&test_callbacks, 0);
	if (!kvm) {
	    fprintf(stderr, "kvm_init failed\n");
	    return 1;
	}
	if (kvm_create(kvm, 128 * 1024 * 1024, &vm_mem) < 0) {
	    kvm_finalize(kvm);
	    fprintf(stderr, "kvm_create failed\n");
	    return 1;
	}
	if (ac > 1)
	    if (strcmp(av[1], "-32") != 0)
		load_file(vm_mem + 0xf0000, av[1]);
	    else
		enter_32(kvm);
	if (ac > 2)
	    load_file(vm_mem + 0x100000, av[2]);
	kvm_show_regs(kvm, 0);

	kvm_run(kvm, 0);

	return 0;
}
